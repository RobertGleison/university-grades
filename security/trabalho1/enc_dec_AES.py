import os
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from time import time

def encrypt_files(folder_name: str) -> dict:
    keys = {} # Guarda as chaves para decriptação
    encryption_times = {} # Guarda os tempos de encriptação
    
    for filename in os.listdir(folder_name):
        key = os.urandom (32)  # A chave tem 256 bits = 32 bytes
        cipher = Cipher(algorithms.AES(key), modes.ECB()) # Cria a cypher
        encryptor = cipher.encryptor() # Cria o encriptador
        padder = padding.PKCS7(algorithms.AES.block_size).padder() # Cria o padder
        filepath = os.path.join(folder_name, filename) # Para cada iteração, cria o caminho do arquivo. Ex: files_aes/random_aes_512.txt

        if os.path.isfile(filepath): # Verufuca se existe um arquivo com esse path
            with open(filepath, "rb") as file:
                plaintext = file.read() # Se existir, lê o arquivo
                if len(plaintext) % 16 != 0: # Adiciona padding para os arquivos que não são mutiplos de 16 bits. Especificação do AES ter tamanhos em bloco de 16
                    plaintext = padder.update(plaintext) + padder.finalize() # Adiciona o padding para dar multiplo de 16

            start_time = time()
            ct = encryptor.update(plaintext) + encryptor.finalize() # Encripta a mensagem
            encryption_time = time() - start_time
            
            temp_list = filename.split("_")
            temp_list2 = temp_list[2].split(".")
            output_file = f"encrypted_{temp_list[1]}_{temp_list2[0]}.txt" # Cria o nome do arquivo encrioptado

            with open(os.path.join('encrypted_files_aes', output_file), "wb") as cphFile: #Acessa o caminho do arquivo criado. Ex: randim_aes_8_encripted.txt
                cphFile.write(ct)
            
        encryption_times[temp_list2[0]] = encryption_time
        keys[output_file] = key # Adiciona a chave e o arquivo no dicionario
    return keys, encryption_times


def decrypt_files(folder_name: str, keys: dict) -> dict:
    decryption_times = {} # Guarda os tempos de decriptação
    if not os.path.exists('decrypted_files_aes'):
        os.makedirs('decrypted_files_aes')

    for file_name, key in keys.items():
        cipher = Cipher(algorithms.AES(key), modes.ECB()) # passa a chave para o cipher
        decryptor = cipher.decryptor() # cria um decriptador com cipher
        with open(os.path.join(folder_name, file_name), 'rb') as cypher:
            ct = cypher.read()
            start_time = time()
            pt = decryptor.update(ct) + decryptor.finalize() # Decripta o texto encriptado
            decryption_time = time() - start_time
        
        temp_list = file_name.split("_")
        output_file = f"decrypted_{temp_list[1]}_{temp_list[2]}.txt" # Cria o nome do arquivo decriptado
        with open(os.path.join('decrypted_files_aes', output_file), "wb") as cphFile:
                cphFile.write(pt)
        decryption_times[temp_list[2]] = decryption_time
    return decryption_times
    

def remove_files(folder_name: str) -> None:
    for file in folder_name:
        os.remove(file)


# Mudar o path para as pastas do seu notebook
files_folder = "/home/robert/university/university-grades/security/trabalho1/files_aes"
file_names = []
# Cria um ditetório para os arquivos encriptados
if not os.path.exists('encrypted_files_aes'):
    os.makedirs('encrypted_files_aes')

# Calcula o tempo médio de cada arquivo encriptado e decriptado
average_encrypt_times = {}
average_decrypt_times = {}
encrpypt_times_sum = [0 for i in range(7)]
decrpypt_times_sum = [0 for i in range(7)]
iterations = 1
for i in range(iterations):
    keys, encrypt_times = encrypt_files(files_folder)
    decrypt_times = decrypt_files('encrypted_files_aes', keys)
    sorted_encrypt_times = sorted(encrypt_times.items(), reverse=True)
    sorted_decrypt_times = sorted(decrypt_times.items(), reverse=True)
    for index, (key, value) in enumerate(sorted_encrypt_times):
        encrpypt_times_sum[index] += value
    for index, (key, value) in enumerate(sorted_decrypt_times):
        decrpypt_times_sum[index] += value

print("Encrypt times: ")
for sum in encrpypt_times_sum:
    average = sum/iterations
    print(f"{average:.8f}") 

print("\nDecrypt times: ")
for sum in decrpypt_times_sum:
    average = sum/iterations
    print(f"{average:.8f}") 

# Calcula o tempo médio de cada arquivo dncriptado





