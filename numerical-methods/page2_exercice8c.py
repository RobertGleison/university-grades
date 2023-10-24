import math as m

def f(x):
    return m.e**x - 3*x

def f_line(x):
    return m.e**x -3

def f_isolated(x):
    return m.e**x/3

def f_newton(x):
    return x - f(x)/f_line(x)

def bisection(a,b,error):
    if(f(a) * f(b) < 0):
        print("Não tem raiz")
        return
    while (abs((a-b)/2) > error):
        x = (a+b)/2
        if f(x) == 0: 
            print(x)
            break
        elif(f(a) * f(x) < 0): b=x
        elif(f(a) * f(x) > 0): a=x
    print(x)

def iterative(a,b,error):
    x0 = (a+b)/2
    x1 = f_isolated(x0)
    while(abs(x1-x0)> error):
        x0 = x1
        x1 = f_isolated(x0)
    print(x1)

def newton(a,b,error):
    x0 = (a+b)/2
    x1 = f_newton(x0)
    while(abs(x1-x0)> error):
        x0 = x1
        x1 = f_newton(x0)
    print(x1)


bisection(0.5,2,1e-8)
iterative(0.5,1,1e-8)
newton(0.5,1,1e-8)