import random

with open("temp", "w") as file:
    for i in range(1, 1001):
        line = ''.join(str(random.choice([0, 1])) for _ in range(1, 1001))
        file.write(line + "\n")
