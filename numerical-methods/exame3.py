import numpy as np


def interpolation(x, x_values, f_values):
    result = 0
    for i in range(len(x_values)):
        mult = 1
        for j in range(len(x_values)):
            if i == j:
                continue
            mult *= (x-x_values[j])/(x_values[i]-x_values[j])
        result += mult * f_values[i]
    return result


print(
    f"Linear interpolation: {interpolation(1.38,[1.37,1.40],[0.1367,0.1461])}")
print(
    f"Squared interpolation: {interpolation(1.38,[1.35,1.37,1.40],[0.1303,0.1367,0.1461])}")

# ------------------------------------------------------------------------------

# n é o grau do polinômio. Se vc tem 8 pontos, deve passar n=7. O grau é sempre 1 - o numero de termos do polinômio.


def MinimumSquares(x_values, f_values, n):
    A = [[x**k for x in x_values] for k in range(n+1)]
    A = np.array(A)
    At = np.transpose(A)
    f = np.array(f_values)
    a = np.linalg.solve(np.matmul(A, At), np.matmul(A, f))
    return a

# #Calcular o valor de x utilizando os coeficientes. No caso, queremos calcular o valor de 1.22. Então f(1.22) = coefs[0]*1.22⁰ + coefs[0]*1.22¹ + coefs[0]*1.22²


def polynomial(coefs, x):
    res = 0
    for i in range(len(coefs)):
        res += coefs[i] * x**i
    return res

# #Soma dos resíduos. Resíduo é a distância entre a linha do polinônio do gráfico e o ponto original. Se vc tem 8 pontos originais, o grau do polinônio é 7.


def residue_norm_squared(x_values, f_values, coefs):
    residue = 0
    for i in range(len(x_values)):
        residue += (f_values[i] - polynomial(coefs, x_values[i]))**2
    return residue


x_values = [1.0, 1.05, 1.1, 1.15, 1.2, 1.25, 1.3, 1.35]
f_values = [1.0, 1.01, 1.02, 1.04, 1.05, 1.06, 1.065, 1.08]
coefs = MinimumSquares(x_values, f_values, 7)
print(coefs)
print(polynomial(coefs, 1.22))
print(residue_norm_squared(x_values, f_values, coefs))


# #--------------------------------------------------------------------------------------------------------------------------------------------------------------------

def minSquare(x_values, f_values, n):
    a = [[x**k for x in x_values] for k in range(n+1)]
    a = np.array(a)
    at = np.transpose(a)
    f =np.array(f_values)
    a = np.linalg.solve(np.matmul(a,at), np.matmul(a,f))
    return a

x_values = []
f_value = []
coefs = minSquare(x_values, f_values, 7)

def polynomial(coefs, x):
    result = 0
    for i in range(len(coefs)):
        result += coefs[i] * (x ** i)
    return result

def residue(x_values, f_values):
    result = 0
    for i in range(len(x_values)):
        result+= (f_values[i] - polynomial(coefs, x_values[i]))**2
    return result 



    

