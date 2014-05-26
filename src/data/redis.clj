(ns data.redis
  (:require [taoensso.carmine :as car :refer (wcar)])
  (:require [clojure.string :as cstr]))

; connects by default to localhost
(def conn {:pool {} :spec {}})

; macro to perform queries
(defmacro wcar* [& body] `(car/wcar conn ~@body))

; get data by key
(defn db-get-by-key [key]
  (wcar* (car/get key)))

; get all
(defn db-search-keys [test_type rc]
  (wcar* (car/keys (str rc ":" test_type "*"))))

; convert redis data key to json
(defn convert-redis-key-to-json [key]
  (let [ key-data (cstr/split key #":")]
    { :rc (nth key-data 0) :type (nth key-data 1) :timestamp (nth key-data 2) :duration (nth key-data 3) }))
