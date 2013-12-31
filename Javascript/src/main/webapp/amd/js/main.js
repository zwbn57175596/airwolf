require.config({
	paths: {
		jquery: 'jquery-2.0.3.min'
	}
});

require(['test_a'], function(testjquery){
	testjquery();
});