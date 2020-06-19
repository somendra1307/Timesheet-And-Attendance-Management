(function($) {

  'use strict';

  $(document).on('show.bs.tab', '.nav-tabs-responsive [data-toggle="tab"]', function(e) {
    let $target = $(e.target);
    let $tabs = $target.closest('.nav-tabs-responsive');
    let $current = $target.closest('li');
    let $parent = $current.closest('li.dropdown');
		$current = $parent.length > 0 ? $parent : $current;
    let $next = $current.next();
    let $prev = $current.prev();
    let updateDropdownMenu = function($el, position){
      $el
      	.find('.dropdown-menu')
        .removeClass('pull-xs-left pull-xs-center pull-xs-right')
      	.addClass( 'pull-xs-' + position );
    };

    $tabs.find('>li').removeClass('next prev');
    $prev.addClass('prev');
    $next.addClass('next');
    
    updateDropdownMenu( $prev, 'left' );
    updateDropdownMenu( $current, 'center' );
    updateDropdownMenu( $next, 'right' );
  });

})(jQuery);