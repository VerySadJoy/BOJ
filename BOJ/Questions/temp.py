from collections import deque

def get_direction(from_pos, to_pos):
    directions = {
        (-1, 0): 'A',
        (-1, 1): 'Q',
        (0, 1): 'W',
        (1, 1): 'E',
        (1, 0): 'D',
        (1, -1): 'C',
        (0, -1): 'X',
        (-1, -1): 'Z'
    }
    move = (to_pos[0] - from_pos[0], to_pos[1] - from_pos[1])
    return directions[move]

def bfs_path(start):
    queue = deque([(start, [])])
    visited = set()
    visited.add(start)
    
    while queue:
        current_pos, path = queue.popleft()
        if current_pos == (0, 0):
            return path
        
        for dx in [-1, 0, 1]:
            for dy in [-1, 0, 1]:
                if dx == 0 and dy == 0:
                    continue
                next_pos = (current_pos[0] + dx, current_pos[1] + dy)
                if next_pos not in visited:
                    visited.add(next_pos)
                    queue.append((next_pos, path + [next_pos]))
    
    return None

def generate_instructions(positions):
    instructions = []
    
    for pos in positions:
        path = bfs_path(pos)
        if path is not None:
            directions = [get_direction(pos if i == 0 else path[i - 1], path[i]) for i in range(len(path))]
            instructions.append(''.join(directions))
    
    return instructions

def main():
    n = int(input().strip())
    positions = [tuple(map(int, input().strip().split())) for _ in range(n)]
    
    instructions = generate_instructions(positions)
    
    for instruction in instructions:
        print(instruction)

if __name__ == "__main__":
    main()