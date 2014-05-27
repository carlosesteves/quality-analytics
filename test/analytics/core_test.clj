(ns analytics.core-test
  (:require [clojure.test :refer :all]
            [analytics.core :refer :all])
  (:require [data.results :as results])
  (:require [analytics.core :as web-app])
  (:use clojure.contrib.mock))

(defn request [resource web-app & params]
  (web-app {:request-method :get :uri resource :params (first params)}))

; test route to get all results
(deftest test-get-all-results
  (.setDynamic #'results/get-builds)
  (expect [results/get-builds (returns [])]
    (is (= 200 (request "/results/rc202/all" web-app/app)))))
;  (is (= "Hello, World!"
;       (:body (request "/" web-app/app))))
