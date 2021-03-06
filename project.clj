(defproject analytics "0.0.1"
  :description "Quality analytics"
  :url "https://github.com/carlosesteves/quality-analytics"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-json "0.2.0"]
                 [ring-json-params "0.1.3"]
                 [compojure "1.1.6"]
                 [clj-json "0.3.2"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.clojure/tools.cli "0.2.4"]
                 [com.novemberain/monger "2.0.0-rc1"]]
  :main analytics.core)
