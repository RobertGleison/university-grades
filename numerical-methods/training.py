#Last year test practice

def values(x):
    dict = {
        1.0: 1.363,
        1.1: 1.213,
        1.2: 1.013,
        1.3: 0.773
    }
    return dict[x]

def central_diff(x,a,b,n):
    h=(b-a)/n
    return (values(x+h) - values(x-h)) / (2*h)

print(f"Number 1: {central_diff(1.25,1.0,1.3,3):.3f}")

# def f(x):
#     return 1+x**2

# def compound_simpson(f,a,b,n,m):
#     h = (b-a)/n
#     x = [a+i*h for i in range(n+1)]
#     result = 0
#     for i in range(n+1):
#         if(i==0 or i==n):
#             result += f(x[i])
#         elif(i%2==0):
#             result+= f(x[i])*2
#         else: result += f(x[i])*4
#     error = abs((-h**4)/180)*(b-a)*m
#     result *= h/3
#     return result, error

result,error= compound_simpson(f,1,2,6,0)
print(f"Simpson: {result}, erro: {error}")