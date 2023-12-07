def interpolation(x, x_vals, f_vals):
    result = 0
    for i in range(len(x_vals)):
        mult = 1
        for j in range(len(x_vals)):
            if (j == i):
                continue
            mult *= (x - x_vals[j]) / (x_vals[i] - x_vals[j])
        result += mult * f_vals[i]
    return result

import math

print(f"Linear interpolation: {interpolation(math.pi/5, [math.pi/6, math.pi/4], [0.57735, 1])}")
print(f"Squared interpolation: {interpolation(math.pi/5, [0, math.pi/6, math.pi/4], [0, 0.57735, 1])}")