(ns data.results
  (:require [clj-json.core :as json])
  (:require [data.redis :as redis])
  (:use [clojure.tools.logging :only (info error)]))

; get results for test with id
(defn get-results [id]
  (let [response (redis/db-search-keys "performance")]
    (if (nil? response)
      (do
        (error (str "This is nil")))
      (do
        (info "Result not nil" response)
        {:id response}))))

; get last build time
(defn get-last-build [type rc]
  (let [results (redis/db-search-keys type rc)]
    (if (= 0 (count results))
      (do
        (error "No results found in database")
        {:status 404 :rc rc :type type :duration "0"})
      (let
        [result (redis/db-get-by-key (first results))]
        (info (str "Result is " result))
        {:status 200 :rc rc :type type :duration result}))))

(defn get-builds [test_type]
  (map redis/convert-redis-key-to-json
      (redis/db-search-keys "test" test_type)))