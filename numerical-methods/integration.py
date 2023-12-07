import math
def f(x):
    return math.e**x

def retangulos_simples(f, a, b, M):
    resultado = (b-a)*f(a)
    erro = 1/2 * M * (b-a)**2
    return resultado, erro

def ret_composto(f, a, b, n, M):
    h = (b-a)/n
    x_list = [a+i*h for i in range(n+1)]
    res = 0
    for i in range(1, n+1):
        res += f(x_list[i-1])
    res *= h
    erro = (b-a)/2 * h * M
    return res, erro

def trapezios_simples(f, a, b, M):
    resultado = 1/2 * (b-a) * (f(a)+f(b))
    erro = abs(-1/12 * M * (b-a)**3)
    return resultado, erro

def trap_composto(f, a, b, n, M):
    h = (b-a)/n
    x_list = [a+i*h for i in range(n+1)]
    res = h/2 * (f(a) + f(b))
    for i in range(1, n):
        res += h*f(x_list[i])
    erro = abs(-1/12 * h**2 * (b-a) * M)
    return res, erro

def simpson_simples(f, a, b, M):
    pt_m = (a+b)/2
    resultado = ((b-a)/6) * (f(a) + 4*f(pt_m) + f(b))
    erro = abs(-1/90 * M * ((b-a)/2)**5)
    return resultado, erro

def simpson_composto(f, a, b, n, M):
    h = (b-a)/n
    x_list = [a+i*h for i in range(n+1)]
    c = [2,4]
    res = 0
    for i in range(n+1):
        if i == 0 or i == n:
            res += f(x_list[i])
            continue
        res += c[i%2]*f(x_list[i])
    res *= h/3
    erro = abs(-1/180 * h**4 * (b-a) * M)
    return res, erro
