(ns data.mongo
  (:require [monger.core :as mg] [monger.collection :as mc])
  (:require [clojure.string :as str])
  (:import [com.mongodb MongoOptions ServerAddress]))


; localhost, default port
;(defn connect [db-name]
;  (mg/connect db (mg/get-db db-name))

; insert into mongodb
;(defn insert [db-name data]
;  (mc/insert db db-name data))

; find maps
(defn find-builds-by-project-stage [project stage]
  (println (str "Connecting to 172.18.11.95 port 27017" ))
  (let [conn (mg/connect {:host "172.18.11.95" :port 27017})
        db   (mg/get-db conn "data")
        coll "data"]
    (println "Searching for project " project)
    (mc/find-one-as-map db coll {"projects" project}, {"_id" 0, stage 1, "projects" 1})))

(defn find-builds-by-project [project stage]
  (println (str "Connecting to 172.18.11.95 port 27017" ))
  (let [conn (mg/connect {:host "172.18.11.95" :port 27017})
        db   (mg/get-db conn "data")
        coll "data"]
    (if (str/blank? stage)
      (mc/find-one-as-map db coll {"projects" project} {"_id" 0})
      (mc/find-one-as-map db coll {"projects" project} {"_id" 0, stage 1, "projects" 1}))))


