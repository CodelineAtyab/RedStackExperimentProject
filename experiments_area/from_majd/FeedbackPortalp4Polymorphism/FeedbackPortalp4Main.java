public class FeedbackPortalp4Main {

    public static void main(String[] args) {

        FeedbackPortal feedbackportal = new FeedbackPortal();

            WebFormFeedback wf=new WebFormFeedback(1, "Aisha", "Great service", 5);
            EmailFeedback ef= new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
            PhoneFeedback pf=new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);
        
        feedbackportal.addFeedback(wf);

        feedbackportal.addFeedback(ef);

        feedbackportal.addFeedback(pf);



        feedbackportal.printReport();
        System.out.println("Average rating: "+feedbackportal.getAverageRating());
    }

}
