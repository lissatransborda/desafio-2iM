import { createBrowserRouter } from "react-router-dom";
import Home from "./pages/Home/Home";
import JobApplication from "./pages/JobApplication/JobApplication";
import Process from "./pages/Process/Process";

const routes = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/candidatura",
    element: <JobApplication />,
  },
  {
    path: "/processo",
    element: <Process />,
  },
]);

export default routes;
