import numpy as np

def interpolation(x_values, f_values, x):
    result = 0
    for i in range(len(x_values)):
        mult = 1
        for j in range(len(x_values)):
            if i == j:
                continue
            mult *= (x-x_values[j])/(x_values[i] - x_values[j])
        result += mult * f_values[i]
    return result


# print(f"Linear interpolation: {interpolation([1.37,1.40],[0.1367,0.1461], 1.38)}")
# print(f"Squared interpolation: {interpolation([1.35,1.37,1.40],[0.1303,0.1367,0.1461], 1.38)}")


#------------------------------------------------------------------------

def minSquared(x_values, f_values, n):
    a = [[x**k for x in x_values] for k in range (n+1)]
    a = np.array(a)
    at = np.transpose(a)
    f = np.array(f_values)
    result = np.linalg.solve(np.matmul(a, at), np.matmul(a,f))
    return result

x_values = [1.0,1.05,1.1,1.15,1.2,1.25,1.3,1.35]
f_values = [1.0,1.01,1.02,1.04,1.05,1.06,1.065,1.08]
coefs = minSquared(x_values, f_values, 1)

def polynomial(coefs, x):
    result = 0
    for i in range(len(coefs)):
        result += coefs[i] * x**i
    return result

def residue(x_values, f_values, coefs):
    result = 0
    for i in range(len(x_values)):
        result += (f_values[i] - polynomial(coefs, x_values[i]))**2 
    return result

print(coefs)
print(polynomial(coefs, 1.22))
print(residue(x_values, f_values, coefs))
