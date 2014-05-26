(ns analytics.web
  (:use compojure.core)
  (:use ring.middleware.json-params)
  (:use ring.adapter.jetty)
  (:require [clj-json.core :as json])
  (:require [data.results :as results])
  (:require [analytics.web :as web]))


(defn json-response [data & [status]]
  {:status (get data :status)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

; routes list
(defroutes handler
  ;(GET "/test/results/performance/all" []
   ; (json-response {:test "all results"}))
  (GET "/test/results/:id" [id]
    (json-response (results/get-results id)))
  (GET "/results/:rc/:type/last" [rc type]
    (json-response (results/get-last-build type rc))))

