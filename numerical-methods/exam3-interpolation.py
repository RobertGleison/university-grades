
# Questão número 1
def interpolation(x, x_values, f_values):
    result = 0
    for i in range(len(x_values)):
        mult = 1
        for j in range(len(x_values)):
            if(j==i):
                continue
            mult*= (x-x_values[j])/(x_values[i]-x_values[j])
        result+=mult*f_values[i]
    return result

print("Linear interpolation", interpolation(1.38, [1.37,1.40], [0.1367,0.1461]))
print("Squared interpolation", interpolation(1.38, [1.35,1.37,1.40], [0.1303,0.1367,0.1461]))

# Na interpolação linear, vc pega os 2 pontos mais próximos do x
# Linear interpolation:
# x1=(1.38 - 1.37)/(1.40 - 1.37) * 0.1461
# x2=(1.38 - 1.40)/(1.37 - 1.40) * 0.1367
# print(x1 + x2)


# Na interpolação quadrada, vc pega os 3 pontos mais próximos do x
# Squared interpolation:
# x2 = ((1.38 - 1.35) * (1.38 - 1.40) / ((1.37 - 1.35) * (1.37 - 1.40))) * 0.1367
# x1 = ((1.38 - 1.37) * (1.38 - 1.40) / ((1.35 - 1.37) * (1.35 - 1.40))) * 0.1303
# x3 = ((1.38 - 1.35) * (1.38 - 1.37) / ((1.40 - 1.35) * (1.40 - 1.37))) * 0.1461
# print(x1+x2+x3)

# ---------------------------------------------------------------------------------------------------

# Questão número 2




















# print("Linear interpolation", interpolation(1.38, [1.37,1.40], [0.1367,0.1461]))
# print("Squared interpolation", interpolation(1.38, [1.35,1.37,1.40], [0.1303,0.1367,0.1461]))






























