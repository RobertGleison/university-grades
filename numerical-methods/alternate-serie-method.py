import math

# def calculate_serie(x, min_error):
#     sum = 0
#     n_term=0
#     term=1
#     while(abs(term)>=min_error):
#         sum+=term
#         term*= -1 * (x**2)/(n_term+1)
#         n_term+=1
#     print(f"Resultado: {sum}\nNumero de termos adicionados: {n_term}")
# calculate_serie(0.5,1e-9)

def aprox_serie_alternada(x, erro):
    soma = 0
    i = 0 # esta serie comeca em 0
    termo = 1 # primeiro termo da serie
    while (abs(termo) >= erro):
        soma += termo
        termo *= -1 * (x**2) / (i+1) # expressao que permite calcular o proximo termo a partir do anterior
        i += 1
    print(f"Resultado: {soma}\nNumero de termos adicionados: {i}")
aprox_serie_alternada(0.5, 1e-9)

 