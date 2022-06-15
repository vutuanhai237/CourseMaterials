double x = x * 2



quicksort:: (Ord a) => [a]->[a]
quicksort [] = []
quicksort (x: xs) = 
    let smaller = quicksort [a | a <- xs, a <= x]
        bigger = quicksort [a | a <- xs, a > x]
    in smaller ++ [x] ++ bigger


factorial:: (Integer) -> Integer
factorial 0 = 1
factorial x = x * factorial (x - 1)


-- GreaterThan2::[a] -> [a]
f xs = [x | x <- xs, x > 2]
ffilter xs = filter (\x -> x > 2) xs