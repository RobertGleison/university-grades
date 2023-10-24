import math as m

def f(x):
    return m.log(x, m.e) - (x**2) + 2

def f_line(x):
    return 1/x - 2*x

def newton_method(a,b,error):
    x0 = (a + b) / 2
    x1 = x0 - f(x0)/f_line(x0)
    while abs(x1-x0) > error:
        x0 = x1
        x1 = x0 - f(x0)/f_line(x0)
    print(x1)

newton_method(0.1,0.2,1e-5)