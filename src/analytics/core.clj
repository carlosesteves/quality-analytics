(ns analytics.core
  (:use compojure.core)
  (:use ring.middleware.json-params)
  (:use ring.adapter.jetty)
  (:require [analytics.web :as web])
  (:require [utils.utils :as utils])
  (:require [analytics.core :as core])
  (:require [clojure.tools.cli :as cli]))

;(def app-settings [& args]
;  (utils/load-config (first args))
;  (info "Loading file " (first (str args))))

; app settings
(def app
  (-> web/handler
    wrap-json-params))

(defn -main [& port]
  ;(app-settings args)
  (if (nil? port)
    (run-jetty #'core/app {:port 8080})
    (run-jetty #'core/app {:port (Integer. port)})))



