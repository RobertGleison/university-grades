import math

def f_isolated(x):
    return math.e**(-0.2*math.sin(x))

def simple_iterative(a, b, iter, l):
    x0 = a
    x1 = f_isolated(x0)
    n = 0
    largest_error = abs(b-a)
    while n < iter:
        x0 = x1
        x1 = f_isolated(x0)
        largest_error *=l
        n+=1
    print(x1)
    print(largest_error)

simple_iterative(0.8,0.9,10, L)