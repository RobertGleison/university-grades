# import os
# from binascii import hexlify
# from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
# from cryptography.hazmat.primitives import padding
# from time import time

# def encrypt_files(folder_name: str) -> dict:
#     keys = {}
#     encryption_times = {}
#     for filename in os.listdir(folder_name):
#         # A cahve tem 256 bits = 32 bytes
#         key = os.urandom (32)
#         cipher = Cipher(algorithms.AES(key), modes.ECB()) # Cria a cypher
#         encryptor = cipher.encryptor() 
#         padder = padding.PKCS7(algorithms.AES.block_size).padder() # Cria o padder
#         filepath = os.path.join(folder_name, filename)

#         if os.path.isfile(filepath):
#             with open(filepath, "rb") as file:
#                 plaintext = file.read() 
#                 if len(plaintext) % 16 != 0: # Adiciona padding para os arquivos que não são mutiplos de 16 bits. Especificação do AES ter tamanhos em bloco de 16
#                     plaintext = padder.update(plaintext) + padder.finalize()

#             start_time = time()
#             ct = encryptor.update(plaintext) + encryptor.finalize()
#             final_time = time()
#             output_file = f"{filename}_encrypted"

#             with open(os.path.join('encrypted_files_aes', output_file), "wb") as cphFile:
#                 cphFile.write(ct)
#         keys[output_file] = key

#         temp_list = filename.split("_")
#         temp_list = temp_list[2].split(".")
#         bits_size = temp_list[0]

#         encryption_times[bits_size] = final_time - start_time
#     return keys, encryption_times

# def decrypt_files(folder_name: str, keys: dict) -> None:
#     if not os.path.exists('decrypted_files_aes'):
#         os.makedirs('decrypted_files_aes')

#     for file_name, key in keys.items():
#         cipher = Cipher(algorithms.AES(key), modes.ECB())
#         decryptor = cipher.decryptor()
#         with open(os.path.join(folder_name, file_name), 'rb') as cypher:
#             ct = cypher.read()
#             pt = decryptor.update(ct) + decryptor.finalize()
        
#         temp_list = file_name.split("_")
#         output_file = f"decrypted_{temp_list[1]}_{temp_list[2]}"
#         with open(os.path.join('decrypted_files_aes', output_file), "wb") as cphFile:
#                 cphFile.write(pt)
    

# def remove_files(folder_name: str) -> None:
#     for file in folder_name:
#         os.remove(file)


# # Mudar o path para as pastas do seu notebook
# files_folder = "/home/robert/university/university-grades/security/trabalho1/files_aes"
# file_names = []
# # Cria um ditetório para os arquivos encriptados
# if not os.path.exists('encrypted_files_aes'):
#     os.makedirs('encrypted_files_aes')

# average_encryption_times = {}
# sums = [0 for i in range(7)] 

# for i in range(100):
#     keys, times = encrypt_files(files_folder)
#     sorted_times = sorted(times.items())

#     for index, (key, value) in enumerate(sorted_times):
#         sums[index] += value
        
# for sum in sums:
#     sum = sum / 100

# for average in sums:
#     print(average)
#     # decrypt_files ('encrypted_files_aes', keys)



