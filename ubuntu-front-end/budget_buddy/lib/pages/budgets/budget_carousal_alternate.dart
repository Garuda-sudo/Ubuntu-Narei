import 'package:flutter/material.dart';
import 'package:flutter_portal/flutter_portal.dart';

import '../../models/budget.dart';

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
                                  color: Colors.white,
                                  borderRadius: BorderRadius.circular(17),
                                ),
                                child: PortalTarget(
                                  visible: isMenuOpen,
                                  anchor: const Aligned(
                                    follower: Alignment.topLeft,
                                    target: Alignment.topRight,
                                  ),
                                  portalFollower: const Material(
                                    elevation: 8,
                                    child: IntrinsicWidth(
                                      child: Column(
                                        mainAxisSize: MainAxisSize.min,
                                        children: [
                                          ListTile(title: Text('option 1')),
                                          ListTile(title: Text('option 2')),
                                        ],
                                      ),
                                    ),
                                  ),
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
                                          setState(() {
                                            isMenuOpen = true;
                                          });
                                        }),
                                  ),
                                )),
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
}
