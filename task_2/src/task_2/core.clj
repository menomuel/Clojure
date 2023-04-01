(ns task-2.core)

(def firstPrimes [2, 3, 5, 7, 11, 13])
(def testArr (range 2 101))

(defn removeDividents
  [arr p]
  (filter (fn [x] (or (= x p) (not (= (mod x p) 0))))
          arr)
  )

(defn genUpperBound
  [n]
  (* n (+ (Math/log n) (Math/log (Math/log n))))
  )

(defn genUpperBoundInt
  [n]
  (+ 1 (int (genUpperBound n)))
  )

(defn sieve
  ([arr] (sieve arr nil))
  ([arr primes]
    (if (empty? arr)
      primes
      (let [arrModified (removeDividents arr (first arr))]
        (recur (rest arrModified) (conj (vec primes) (first arrModified)))
       )
      )
     )
  )

(defn getPrimeNumber
  [n]
  (if (<= n 5)
    (nth firstPrimes n)
    (let [arr (range 2 (+ 1 (genUpperBoundInt n)))]
      (nth (sieve arr) n)
      )
    )
  )

(defn bar
  [aaa]
  (* aaa 3))
