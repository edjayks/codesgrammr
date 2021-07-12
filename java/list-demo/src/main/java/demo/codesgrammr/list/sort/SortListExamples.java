/*
 * Copyright 2021 Mong Kok Seong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package demo.codesgrammr.list.sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListExamples {

    public static void main(String[] args) {
        SortListExamples sortListExamples = new SortListExamples();
        sortListExamples.runExamples();
    }

    public void runExamples() {

        sortList();
        sortIntegersLIst();
        reverseList();
        reversedOrderComparatorList();
        sortListComparator();
        sortPurchaseOrderById();
    }

    private void sortList() {
        List myList = Arrays.asList("finland", "england", "denmark", "china", "bahamas", "argentina");

        Collections.sort(myList);

        myList.stream().forEach(myItem -> System.out.println(myItem));
    }

    private void sortIntegersLIst() {
        List myList = Arrays.asList("146743", "390155", "755915", "783980", "552473", "657174");

        Collections.sort(myList);

        myList.stream().forEach(myItem -> System.out.println(myItem));
    }

    private void reverseList() {
        List myList = Arrays.asList("alice", "john", "zelda", "bob", "chen", "ali");

        Collections.reverse(myList);

        myList.stream().forEach(myItem -> System.out.println(myItem));
    }

    private void reversedOrderComparatorList() {
        List myList = Arrays.asList("alice", "john", "zelda", "bob", "chen", "ali");

        Collections.sort(myList, Collections.reverseOrder());

        myList.stream().forEach(myItem -> System.out.println(myItem));
    }

    private void sortListComparator() {
        List myList = Arrays.asList("finland", "england", "denmark", "china", "bahamas", "argentina");

        Collections.sort(myList, (Comparator<String>) (o1, o2) -> {
            if (o1.compareTo(o2) > 0) {
                return -1;
            } else if (o1.compareTo(o2) < 0) {
                return 0;
            }
            return 0;
        });

        myList.stream().forEach(myItem -> System.out.println(myItem));
    }

    private void sortPurchaseOrderById() {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(1L);
        purchaseOrder.setCreatedDate(LocalDateTime.now());
        purchaseOrder.setCustomerId(12L);
        purchaseOrder.setQuantity(10);
        purchaseOrder.setItemId(5L);
        purchaseOrders.add(purchaseOrder);

        purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(2L);
        purchaseOrder.setCreatedDate(LocalDateTime.now().minusHours(1));
        purchaseOrder.setCustomerId(20L);
        purchaseOrder.setQuantity(8);
        purchaseOrder.setItemId(6L);
        purchaseOrders.add(purchaseOrder);

        purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(3L);
        purchaseOrder.setCreatedDate(LocalDateTime.now().minusDays(1));
        purchaseOrder.setCustomerId(66L);
        purchaseOrder.setQuantity(3);
        purchaseOrder.setItemId(2L);
        purchaseOrders.add(purchaseOrder);

        purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(4L);
        purchaseOrder.setCreatedDate(LocalDateTime.now().minusMinutes(10));
        purchaseOrder.setCustomerId(5L);
        purchaseOrder.setQuantity(7);
        purchaseOrder.setItemId(59L);
        purchaseOrders.add(purchaseOrder);

        Collections.sort(purchaseOrders, Collections.reverseOrder());

        purchaseOrders.stream().forEach(myItem -> System.out.println(myItem));
    }
}
