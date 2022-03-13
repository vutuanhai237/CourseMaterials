-- Định nghĩa hàm doubleMe
doubleMe x = x*x
doubleUs x y = doubleMe x + doubleMe y
-- Hàm hằng
a = [1, 2, 3, 4]
b = [5, 6]
-- Bài tâp
triangles = [ (a, b, c) | c<-[1..10], b<-[1..10], a<-[1..10], a + b + c == 24, a^2 + b^2 == c^2]

