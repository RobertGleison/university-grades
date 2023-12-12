import math
def f(x):
    return math.e**x


def compound_rectangles(f, a, b, n, m):
    h = (b-a)/n
    x = [a+i*h for i in range(n+1)]
    res = 0
    for i in range(1, n+1):
        res += f(x[i-1])
    res *= h
    error = abs((b-a)/2 * h * m)
    return res, error

def simple_trapezoid(f,a,b):
    return (f(a)+f(b))*(b-a)/2

def compound_trapezoid(f,a,b,n,m):
    h=(b-a)/n
    x=[a+i*h for i in range(n+1)]
    result = 0
    for i in range(n):
        result += simple_trapezoid(f,x[i],x[i+1])
        error = abs((-h**2)/12 *(b-a) * m)
    return result, error

def compound_simpson(f,a,b,n,m):
    h=(b-a)/n
    x=[a+i*h for i in range(n+1)]
    result = 0
    for i in range(n+1):
        if(i==0 or i==n):
            result += f(x[i])
        elif(i%2==0):
            result+=f(x[i])*2
        else: result +=f(x[i])*4
    error = abs(-1/180 * h**4 * (b-a) * m)
    result *= h/3
    return result, error
        

rectangle, errorR = compound_rectangles(f,1,2,4,math.e**2)
trapezoid, errorT = compound_trapezoid(f,1,2,4,math.e**2)
simpson, errorS = compound_simpson(f,1,2,4,math.e**2)
print(f"Rectangle value: {rectangle}, majorant: {errorR}")    
print(f"Trapezoid value: {trapezoid}, majorant: {errorT}")    
print(f"Simpson value: {simpson}, majorant: {errorS}")    