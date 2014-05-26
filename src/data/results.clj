(ns data.test_results
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
(defn get-last-build [build_tag test_type]
  (let [results (redis/db-search-keys build_tag test_type)]
    (if (= 0 (count results))
      (do
        (info "No results found in database")
        {:status 404 :rc build_tag :test_type test_type :duration "0"})
      (let
        [result (redis/db-get-by-key (first results))]
        (info (str "Result is " result))
        {:status 200 :rc build_tag :test_type test_type :duration result}))))
