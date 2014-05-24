(use 'ring.adapter.jetty)
(require '[analytics.web :as web])

(run-jetty #'web/app {:port 8080})