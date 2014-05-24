(ns analytics.web
  (:use compojure.core)
  (:use ring.middleware.json-params)
  (:use ring.adapter.jetty)
  (:require [clj-json.core :as json])
  (:require [data.test_results :as test_results])
  (:require [analytics.web :as web]))


(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

; routes list
(defroutes handler
  ;(GET "/test/results/performance/all" []
   ; (json-response {:test "all results"}))
  (GET "/test/results/:id" [id]
    (json-response (test_results/get-results id))))


; app settings
(def app
  (-> handler
    wrap-json-params))

(def -main
  (run-jetty #'web/app {:port 8080}))

