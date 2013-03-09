(ns clojure-javafx-hello.core
  (:gen-class
   :extends javafx.application.Application)

  (:import (javafx.application Application)
           (javafx.event ActionEvent EventHandler)
           (javafx.scene Scene)
           (javafx.scene.layout StackPane)
           (javafx.scene.control Button)
           (javafx.stage Stage)))

(defn -main [& args]
  (Application/launch clojure_javafx_hello.core args))

(defn -start [this stage]
  (let [root (StackPane.)
        btn (Button.)]

    ;; set text for button
    (.setText btn "Say 'Hello World'");

    ;; add action for button
    (.setOnAction btn
                  (proxy [EventHandler] []
                    (handle [^ActionEvent event]
                      (println "hello world!"))))

    ;; add a button
    (.add (.getChildren root) btn)

    ;; Set scene and show stage
    (.setScene stage (Scene. root 300 250))

    ;; Set window title
    (.setTitle stage "Hello javafx")

    ;; show up
    (.show stage)

    ))
