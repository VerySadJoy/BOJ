match_sequence = input().strip()
rank = 25
stars = 0
win_streak = 0

stars_needed = [0] * 26
stars_needed[21:26] = [2] * 5
stars_needed[16:21] = [3] * 5
stars_needed[11:16] = [4] * 5
stars_needed[1:11] = [5] * 10

for game in match_sequence:
    if game == 'W':
        win_streak += 1
        stars += 1
        
        if 6 <= rank <= 25 and win_streak >= 3:
            stars += 1
        
        if stars > stars_needed[rank]:
            stars -= stars_needed[rank]
            rank -= 1
            if rank == 0:
                print("Legend")
    else:
        win_streak = 0
        if rank <= 20:
            if stars > 0:
                stars -= 1
            else:
                if rank < 20:
                    rank += 1
                    stars = stars_needed[rank] - 1

print(str(rank))
