max'::(Ord a) => a -> a -> a
max' x y 
    | x > y = x
    | otherwise = y