(ns analytics.web
  (:use compojure.core)
  (:use ring.middleware.json-params)
  (:use ring.adapter.jetty)
  (:require [clj-json.core :as json])
  (:require [data.results :as results])
  (:require [analytics.web :as web]))


(defn json-response [data & [status]]
  (println data)
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defn html-response [data]
  (println data)
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body data})

; results routes
(defroutes results-routes
  (GET "/:project/:stage/all" [project stage]
    (json-response (results/get-builds project stage))))
  ;(GET "/:project/:bid/all" [project bid]
   ; (json-response (results/get-builds project bid)))
  ;(GET "/:project/:bid/:stage/all" [project bid stage]
   ; (json-response (results/get-builds project bid stage))))

  ;(GET "/:rc/:type/last" [rc type]
  ;  (json-response (results/get-last-build type rc))))

; routes list
(defroutes handler
  ; API  routes
  (context "/api/results" [] results-routes)
  ; web app routes
  (GET "/" [] (html-response "Hello B")))



