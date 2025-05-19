;; IMPORTANT! place this file under src directory
 (ns core
   (:gen-class))

(defn -main [& _]
  (let [my-var "Hello World"]
    (println my-var)))

(defn test-function [arg]
  (println "test-function" arg))
  