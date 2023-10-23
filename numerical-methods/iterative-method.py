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


def f(x):
    return m.e**(m.sin(x)/5)

def iterative_method(a,b,iter):
    x0=(a+b)/2
    x=f(x0)
    count = 0
    while(count<=iter):
        x0=x
        x=f(x0)
        count+=1
        print(x)

iterative_method(1.2,1.21, 10)