import 'package:budget_buddy/pages/budgets/custom_widgets/radial_menu.dart';
import 'package:flutter/material.dart';
import 'package:flutter_portal/flutter_portal.dart';

import '../../models/budget.dart';

class BudgetList extends StatefulWidget {
  final List<Budget> budgetList;

  const BudgetList({super.key, required this.budgetList});

  @override
  State<BudgetList> createState() => _BudgetListState();
}

class _BudgetListState extends State<BudgetList>
    with SingleTickerProviderStateMixin {
  late AnimationController _animationController;

  @override
  void initState() {
    super.initState();

    _animationController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 900),
    );
  }

  @override
  void dispose() {
    _animationController.dispose();
    super.dispose();
  }

  PageController pageController =
      PageController(viewportFraction: 0.5, initialPage: 1);

  bool isMenuOpen = false;
  int currentPage = 1;
  int previousPage = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        SizedBox(
          height: 280,
          child: PageView.builder(
              itemCount: widget.budgetList.length,
              controller: pageController,
              onPageChanged: _onPageViewChange,
              itemBuilder: (context, index) {
                return Container(
                  margin:
                      const EdgeInsets.symmetric(vertical: 32, horizontal: 17),
                  decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(17),
                      boxShadow: [
                        BoxShadow(
                            blurRadius: 8,
                            color: Colors.black.withOpacity(0.5),
                            offset: const Offset(0, 7)),
                      ]),
                  child: Column(
                    children: [
                      //Container for the top half of the Budget
                      Container(
                        //color: Colors.amber,
                        height: 130,
                        child: Column(
                          children: [
                            Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Text(
                                widget.budgetList[index].name,
                                style: const TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                    letterSpacing: 1.2),
                              ),
                            ),
                            Text(
                              widget.budgetList[index].budgetMotto,
                              style: const TextStyle(
                                  fontSize: 10, letterSpacing: 1.2),
                            ),
                            Padding(
                              padding:
                                  const EdgeInsets.fromLTRB(8.0, 5.0, 8.0, 0),
                              child: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  Container(
                                    child: Text("Balance for Dec"),
                                  ),
                                  Container(
                                    child: Text(
                                        "R ${widget.budgetList[index].budgetTotal}"),
                                  )
                                ],
                              ),
                            ),
                            Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Container(
                                height: 15,
                                width: MediaQuery.of(context).size.width * 0.8,
                                decoration: BoxDecoration(
                                    color: Colors.indigo[300],
                                    borderRadius: BorderRadius.circular(5)),
                              ),
                            ),
                          ],
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 0.0, 8.0, 15.0),
                        child: index == currentPage
                            ? RadialMenuAnimation(
                                controller: _animationController,
                              )
                            : Container(
                                decoration: const BoxDecoration(
                                  shape: BoxShape.circle,
                                  color: Color(0xFFF5C6373),
                                ),
                                child: IconButton(
                                    iconSize: 20,
                                    icon: Icon(Icons.add),
                                    color: Colors.white,
                                    onPressed: () {
                                      print("tapped" + index.toString());
                                      setState(() {
                                        isMenuOpen = true;
                                      });
                                    }),
                              ),
                      )
                    ],
                  ),
                );
              }),
        ),
      ],
    );
  }

  _onPageViewChange(int page) {
    print("Current Page: " + page.toString());
    previousPage = page;
    currentPage = page;
    if (page != 0)
      previousPage--;
    else
      previousPage = 2;
    //print("Previous page: $previousPage");
  }
}


// PortalTarget(
//                                   visible: isMenuOpen,
//                                   anchor: const Aligned(
//                                     follower: Alignment.center,
//                                     target: Alignment.center,
//                                   ),
//                                   portalFollower: CustomPaint(
//                                     painter: RadialMenuPainter(
//                                         innerCircleRadius:
//                                             _animationController.value * 35,
//                                         outerCircleRadius:
//                                             _animationController.value * 190),
//                                     child: Stack(
//                                       children: [
//                                         Positioned(
//                                           child: Container(),
//                                           left: 150,
//                                           top: 300,
//                                         )
//                                       ],
//                                     ),
//                                   ),
//                                   child: Container(
//                                     decoration: const BoxDecoration(
//                                       shape: BoxShape.circle,
//                                       color: Color(0xFFF5C6373),
//                                     ),
//                                     child: IconButton(
//                                         iconSize: 40,
//                                         icon: Icon(Icons.add),
//                                         color: Colors.white,
//                                         onPressed: () {
//                                           print("tapped" + index.toString());
//                                           setState(() {
//                                             isMenuOpen = true;
//                                             print(_animationController.value);
//                                           });
//                                         }),
//                                   ),
//                                 )