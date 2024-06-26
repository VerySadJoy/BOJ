def is_left(p0, p1, p2):
    return ((p1[0] - p0[0]) * (p2[1] - p0[1]) - (p2[0] - p0[0]) * (p1[1] - p0[1])) > 0

def on_segment(p, q, r):
    if q[0] <= max(p[0], r[0]) and q[0] >= min(p[0], r[0]) and q[1] <= max(p[1], r[1]) and q[1] >= min(p[1], r[1]):
        return True
    return False

def orientation(p, q, r):
    val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
    if val == 0:
        return 0
    return 1 if val > 0 else 2

def do_intersect(p1, q1, p2, q2):
    o1 = orientation(p1, q1, p2)
    o2 = orientation(p1, q1, q2)
    o3 = orientation(p2, q2, p1)
    o4 = orientation(p2, q2, q1)

    if o1 != o2 and o3 != o4:
        return True

    if o1 == 0 and on_segment(p1, p2, q1):
        return True

    if o2 == 0 and on_segment(p1, q2, q1):
        return True

    if o3 == 0 and on_segment(p2, p1, q2):
        return True

    if o4 == 0 and on_segment(p2, q1, q2):
        return True

    return False

def segment_intersection(p1, q1, p2, q2):
    def det(a, b):
        return a[0] * b[1] - a[1] * b[0]

    xdiff = (p1[0] - q1[0], p2[0] - q2[0])
    ydiff = (p1[1] - q1[1], p2[1] - q2[1])

    div = det(xdiff, ydiff)
    if div == 0:
        return None

    d = (det(p1, q1), det(p2, q2))
    x = det(d, xdiff) / div
    y = det(d, ydiff) / div
    return (x, y)

def visible_length(screen, viewer, walls):
    lx, ly, rx, ry = screen
    if not is_left((lx, ly), (rx, ry), (viewer[0], viewer[1])):
        return 0.0
    
    visible_segment = [(lx, ly), (rx, ry)]
    for i in range(len(walls)):
        wall_start = walls[i]
        wall_end = walls[(i + 1) % len(walls)]
        if do_intersect(viewer, visible_segment[0], wall_start, wall_end):
            intersection_point = segment_intersection(viewer, visible_segment[0], wall_start, wall_end)
            if intersection_point:
                visible_segment[0] = intersection_point
        if do_intersect(viewer, visible_segment[1], wall_start, wall_end):
            intersection_point = segment_intersection(viewer, visible_segment[1], wall_start, wall_end)
            if intersection_point:
                visible_segment[1] = intersection_point
    
    return ((visible_segment[1][0] - visible_segment[0][0]) ** 2 + (visible_segment[1][1] - visible_segment[0][1]) ** 2) ** 0.5

def main():
    K = int(input().strip())
    
    results = []
    for k in range(1, K + 1):
        n, m, x, y = map(float, input().strip().split())
        n = int(n)
        m = int(m)
        
        corners = []
        for i in range(n):
            xi, yi = map(float, input().strip().split())
            corners.append((xi, yi))
        
        screens = []
        for j in range(m):
            lx, ly, rx, ry = map(float, input().strip().split())
            screens.append((lx, ly, rx, ry))
        
        total_visible_length = 0.0
        total_screen_length = 0.0
        
        for screen in screens:
            lx, ly, rx, ry = screen
            screen_length = ((rx - lx) ** 2 + (ry - ly) ** 2) ** 0.5
            total_screen_length += screen_length
            total_visible_length += visible_length(screen, (x, y), corners)
        
        visible_percentage = (total_visible_length / total_screen_length) * 100
        results.append(f"Data Set {k}:\n{visible_percentage:.2f}")
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
