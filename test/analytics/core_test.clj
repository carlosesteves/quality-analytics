(ns analytics.core-test
  (:require [clojure.test :refer :all]
            [analytics.core :refer :all])
  (:require [data.test_results :as test_results]))

(deftest a-test
  (testing "template test"
    (test_results/get-results 10)
    (is (= 1 1))))
