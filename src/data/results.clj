(ns data.results
  (:require [clj-json.core :as json])
  (:require [data.mongo :as mongo])
  (:use [clojure.tools.logging :only (info error)]))

; get results for test with id

; get last build time
;(defn get-last-build [type rc]
;  (let [results (redis/db-search-keys type rc)]
;    (if (= 0 (count results))
;      (do
;        (error "No results found in database")
;        {:status 404 :rc rc :type type :duration "0"})
;      (let
;        [result (mongo/find-maps )]
;        (info (str "Result is " result))
;        {:status 200 :rc rc :type type :duration result}))))

; get all builds for project & bid
(defn get-builds [project stage]
  (let [query_results (mongo/find-builds-by-project project stage)]
    (if (nil? query_results)
      {:status 404 :message "Data not found"}
      query_results)))