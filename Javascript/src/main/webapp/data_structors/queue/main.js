requirejs.config({
  // By default load any module IDs from js/lib
  baseUrl : './',
  // except, if the module ID starts with "app",
  // load it from the js/app directory. paths
  // config is relative to the baseUrl, and
  // never includes a ".js" extension since
  // the paths config could be for a directory.
  paths : {
  },
});

requirejs(['queue'], function(Queue) {
  var queue = new Queue();
  queue.enq("hello");
  queue.enq("hi");
  console.log("initial : " + queue.size());
  console.log("deq once: " + queue.deq());
  console.log("after deq : " + queue.size());
  console.log("typeof aElement: " + typeof(queue.aElement));
  queue.empty();
  console.log("after empty:" + queue.size());
  console.log("queue is emtpy? " + queue.isEmpty());
});
