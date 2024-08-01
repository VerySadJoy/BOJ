def shift_chars(correct_word, real, indices):
    correct_word_list = list(correct_word)
    n = len(correct_word)
    
    temp = correct_word_list.copy()
    
    if len(indices) > 1:
        for i in range(len(indices)):
            temp[indices[i]] = correct_word_list[indices[i - 1]]
    elif len(indices) == 1:
        for i in range(0, 5):
            if (correct_word[i] == 'F'):
                temp[indices[0]] = real[i]

    return ''.join(temp)

def solve_wordle(N, results):
    import string

    def check_constraints(results):
        for result in results:
            if result.count('G') == 4:
                if result.count('B') != 1:
                    return False
        return True

    def generate_guesses(correct_word, results):
        guesses = []
        for result in results:
            guess = list(correct_word)
            used_word = []
            for i, color in enumerate(result):
                #print(guess)
                if color == 'B':
                    guess[i] = 'F'
                elif color == 'Y':
                    used_word.append(i)
            guess = shift_chars(guess, correct_word, used_word)
            guesses.append("".join(guess))
        return guesses

    if not check_constraints(results):
        print("IMPOSSIBLE")
        return
    
    correct_word = "ABCDE"
    guesses = generate_guesses(correct_word, results)
    
    print(correct_word)
    for guess in guesses:
        print(guess)


N = int(input().strip())
results = [input().strip() for _ in range(N)]

solve_wordle(N, results)