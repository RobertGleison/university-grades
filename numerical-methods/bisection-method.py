import math

#Example
# def f(x):
#     return x**2-5

# def bisection_method(a,b,error):
#     if(f(a) * f(b) < 0):
#         while abs((b-a)/2) > error: 
#             x = (a+b)/2
#             if f(x)== 0: 
#                 print(f"The root is {x}")
#                 break
#             elif f(a) * f(x) < 0: b=x
#             elif f(a) * f(x) > 0: a=x
#         print(f"The aproximation of root is {x}")
#     else: print("There is no root in this interval")
# bisection_method(2,3,0.01)

#2a
# def f(x):
#     return 0.123**x - x
# def bisection_method(a,b,error):
#     if(f(a) * f(b) < 0):
#         while abs((b-a)/2) > error: 
#             x = (a+b)/2
#             if f(x)== 0: 
#                 print(f"The root is {x}")
#                 break
#             elif f(a) * f(x) < 0: b=x
#             elif f(a) * f(x) > 0: a=x
#         print(f"The aproximation of root is {x}")
#     else: print("There is no root in this interval")
# bisection_method(0,1,1e-4)

#2b
def f(x):
    return (x**3) - 2*(math.e**(-x))

def bisection_method(a,b,error):
    if(f(a) * f(b) < 0):
        while(abs((a-b)/2) > error):
            x = (a+b)/2
            if f(x) == 0:
                print(f"The root is {x}")
                break
            elif (f(a) * f(x) < 0): b=x
            elif (f(a) * f(x) > 0): a=x
        print(f"The aproximation of root is {x}")
    else: print("There is not root in this interval")
bisection_method(0,1,1e-5)

# Use this method to reach the root of a function. But the edge points of the interval you chose must have opposite signals