import 'package:flutter/material.dart';
import 'package:flutter_portal/flutter_portal.dart';

import '../../models/budget.dart';
import 'custom_widgets/radial_menu.dart';

class BudgetList extends StatefulWidget {
  final List<Budget> budgetList;

  const BudgetList({super.key, required this.budgetList});

  @override
  State<BudgetList> createState() => _BudgetListState();
}

class _BudgetListState extends State<BudgetList> {
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
                return PortalTarget(
                  visible: isMenuOpen,
                  portalFollower: GestureDetector(
                    behavior: HitTestBehavior.opaque,
                    onTap: () {
                      setState(() {
                        isMenuOpen = false;
                      });
                    },
                  ),
                  child: Container(
                    margin: const EdgeInsets.symmetric(
                        vertical: 32, horizontal: 17),
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
                        Container(
                          //color: Colors.amber,
                          height: 100,
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
                                padding: const EdgeInsets.all(8.0),
                                child: Container(
                                  height: 15,
                                  width:
                                      MediaQuery.of(context).size.width * 0.8,
                                  decoration: BoxDecoration(
                                      color: Colors.indigo[300],
                                      borderRadius: BorderRadius.circular(5)),
                                ),
                              ),
                            ],
                          ),
                        ),
                        Expanded(
                          child: Padding(
                            padding:
                                const EdgeInsets.fromLTRB(8.0, 8.0, 8.0, 15.0),
                            child: Container(
                              decoration: BoxDecoration(
                                color: Colors.amber,
                                borderRadius: BorderRadius.circular(17),
                              ),
                              //Conditional to check whether to add radial menu
                              child: index == currentPage
                                  ? PortalTarget(
                                      visible: isMenuOpen,
                                      anchor: const Aligned(
                                        follower: Alignment.topLeft,
                                        target: Alignment.topRight,
                                      ),
                                      portalFollower: Material(
                                          elevation: 8,
                                          child: CustomPaint(
                                            painter: RadialMenuPainter(),
                                          )),
                                      child: Container(
                                        decoration: const BoxDecoration(
                                          shape: BoxShape.circle,
                                          color: Color(0xFFF5C6373),
                                        ),
                                        child: IconButton(
                                            iconSize: 40,
                                            icon: Icon(Icons.add),
                                            color: Colors.white,
                                            onPressed: () {
                                              print(
                                                  "tapped" + index.toString());
                                              setState(() {
                                                isMenuOpen = true;
                                              });
                                            }),
                                      ),
                                    )
                                  : Container(
                                      decoration: const BoxDecoration(
                                        shape: BoxShape.circle,
                                        color: Color(0xFFF5C6373),
                                      ),
                                      child: IconButton(
                                          iconSize: 40,
                                          icon: Icon(Icons.add),
                                          color: Colors.white,
                                          onPressed: () {
                                            print("tapped" + index.toString());
                                            setState(() {
                                              isMenuOpen = true;
                                            });
                                          }),
                                    ),
                            ),
                          ),
                        )
                      ],
                    ),
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
    print("Previous page: $previousPage");
  }
}
