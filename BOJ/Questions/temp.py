from itertools import combinations

def ArrayChallenge():
    arr = [16, 22, 35, 8, 20, 1, 21, 11]
    arr.sort()
    comb = list(combinations(arr, int(len(arr) / 2)))
    print(comb)
    for i in comb:
        sum1 = sum(i)
        temp = arr.copy()
        for j in i:
            temp.remove(j)
        sum2 = sum(temp)
        if (sum1 == sum2):
            l1 = sorted(list(i))
            l2 = sorted(temp)
            strlst = list(map(str, l1 + l2))
            result = ','.join(strlst)
            # code goes here
            return result
    return -1

    

# keep this function call here 
print(ArrayChallenge())