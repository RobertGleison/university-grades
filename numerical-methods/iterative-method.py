import math as m

# def f(x):
#     return (m.e**x)/3

# def iterative_method(a,b,error):
#     x0 = f()
#     x=f(x0)
#     while(abs(x-x0) > error):
#         x0 = x
#         x = f(x0)
#         print(x)

# iterative_method(0,1,0.001,10)

#-----------------------------------------------------------------------------------------------

def f(x):
    return m.e**(m.sin(x)/5)

def iterative_method(a,b,error):
    x0=a
    x=f(x0)
    count = 0
    while(abs(x-x0)>error):
        count+=1
        x0=x
        x=f(x0)
        count+=1
        print(x)
    print(f"The root is {x:.8f} and the number of iterations is {count}")

iterative_method(1.2,1.21, 1e-7)

#-----------------------------------------------------------------------------------------------
#Exercice number 5

# def f(x):
#     return m.e**(-x)

# def iterative_method(a,b,error):
#     x0=0.52
#     x1=f(x0)
#     while(abs(x1-x0)>error):
#         x0=x1
#         x1=f(x0)
#         print(x1)
#     print(x1)
    
#-----------------------------------------------------------------------------------------------


