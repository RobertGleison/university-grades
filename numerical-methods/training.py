#Last year test practice

def values(x):
    dict = {
        0.3: 0.91,
        0.4: 0.85,
        0.5: 0.78,
        0.6: 0.70,
        0.7: 0.61
    }
    return dict[x]

def central_diff(x,a,b,n):
    h=(b-a)/n
    return (values(x+h) - values(x-h)) / (2*h)

print(f"Number 1: {central_diff(0.5,0.3,0.7,4):.3f}")

def f(x):
    return 1+x**2

def compound_simpson(f,a,b,n,m):
    h = (b-a)/n
    x = [a+i*h for i in range(n+1)]
    result = 0
    for i in range(n+1):
        if(i==0 or i==n):
            result += f(x[i])
        elif(i%2==0):
            result+= f(x[i])*2
        else: result += f(x[i])*4
    error = abs((-h**4)/180)*(b-a)*m
    result *= h/3
    return result, error

result,error= compound_simpson(f,1,2,6,0)
print(f"Simpson: {result}, erro: {error}")