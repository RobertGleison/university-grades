#8b) bisection
import math as m
# def bisection(a,b,error):
#     if(f(a) * f(b) < 0):
#         while abs((a-b)/2) >error:
#             x = (a+b)/2
#             if(f(x)==0): 
#                 print("The root is ", x)
#                 break
#             if(f(a) * f(x)>0): a=x
#             if(f(a) * f(x)<0): b=x
#         print(f"The aproximation of root is {x}")
#     else: print("There is no root in this interval")


def f(x):
    return x - m.e**(-x) - 1/4

def derivada(x):
    return m.e**(-x) + 1

def f_mnewton(x):
    return x - f(x)/derivada(x)

def MNewton(a,b, error):
    x1 = (a + b) / 2
    x2 = f_mnewton(x1)
    while (abs(x2 - x1) > error):
        x1 = x2
        x2 = f_mnewton(x1)
    print(x2)


MNewton(0,1, 1e-8)