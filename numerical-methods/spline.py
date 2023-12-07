

def spline(x_values, f_values, x):
    p0 = 0
    p1 = 0
    for i in range(1,len(x_values)):
        if x_values[i-1]<=x and x<=x_values[i]:
            p0=i-1
            p1=i
            break
    l0 = (x - x_values[p1])/(x_values[p1] - x_values[p0])
    l1 = (x - x_values[p0])/(x_values[p1] - x_values[p0])
    return l1 * f_values[p1] - l0 * f_values[p0]

X = [1, 2, 3, 4]
F = [1, 1/2, 1/3, 1/4]

print(spline(X, F,1.5))
