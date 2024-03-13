import os 

# Cria 3 pastas para cada tipo de arquivos
os.makedirs("files_sha")
os.makedirs("files_aes")
os.makedirs("files_rsa")

file_sizes = [8, 64, 512, 4096, 32768, 262144, 2097152]
rsa_file_sizes = [2, 4, 8, 16, 32, 64, 128]

def generate_random_file_for_sha(size: int) -> None:
    with open(os.path.join('files_sha', f'random_sha_{size}.txt'), 'wb') as f:
        f.write(os.urandom(size))

def generate_random_file_for_aes(size: int) -> None:
    with open(os.path.join('files_aes', f'random_aes_{size}.txt'), 'wb') as f:
        f.write(os.urandom(size))

def generate_random_file_for_rsa(size: int) -> None:
    with open(os.path.join('files_rsa', f'random_rsa_{size}.txt'), 'wb') as f:
        f.write(os.urandom(size))

# Generate random files for SHA hashing
for size in file_sizes:
    generate_random_file_for_sha(size)
    generate_random_file_for_aes(size)

for size in rsa_file_sizes:
    generate_random_file_for_rsa(size)





