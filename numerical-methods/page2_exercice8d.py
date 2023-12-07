import math as m

def f(x):
    return m.cos(x) - (x-2)**2 +1

def f_line(x):
    return -m.sin(x) -2*x+4

def f_newton(x):
    return x - f(x)/f_line(x)

def f_isolate(x):
    return x

def bisection(a,b,error):
    while abs((a-b)/2) > error:
        x = (a+b)/2
        if f(x) == 0:
            print("The exact root is", x)
            break
        elif f(a) * f(x) > 0:  a=x
        elif f(a) * f(x) < 0: b=x
    print(x)

def iterative(a,b,error):
    x1 = (a+b)/2
    x2 = f_isolate(x1)
    while(abs(x2-x1)> error):
        x1 = x2
        x2= f_isolate(x1)
    print(x2)

def newton(a,b,error):
    x1 = (a+b)/2
    x2 = f_newton(x1)
    while(abs(x2-x1)> error):
        x1 = x2
        x2= f_newton(x1)
    print(x2)


bisection(0.65,0.75,1e-8) 
iterative(0.65,0.75,1e-8) 
newton(0.65,0.75,1e-8) 
